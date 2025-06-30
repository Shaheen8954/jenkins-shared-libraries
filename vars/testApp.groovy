def call() {
    echo "Starting application test..."
    
    // Start the application in background
    def appProcess = sh(
        script: "npm run dev > app.log 2>&1 & echo \$!",
        returnStdout: true
    ).trim()
    
    echo "Application started with PID: ${appProcess}"
    
    // Wait a moment for the app to start
    sleep(5)
    
    // Check if the application is running
    def isRunning = sh(
        script: "ps -p ${appProcess} > /dev/null 2>&1",
        returnStatus: true
    )
    
    if (isRunning == 0) {
        echo "✅ Application is running successfully!"
        echo "Waiting 10 seconds before stopping..."
        sleep(10)
        
        // Stop the application
        sh "kill ${appProcess} || true"
        echo "🛑 Application stopped"
        
        // Verify it's stopped
        sleep(2)
        def isStopped = sh(
            script: "ps -p ${appProcess} > /dev/null 2>&1",
            returnStatus: true
        )
        
        if (isStopped != 0) {
            echo "✅ Application successfully terminated"
        } else {
            echo "⚠️ Application may still be running, forcing termination"
            sh "kill -9 ${appProcess} || true"
        }
    } else {
        echo "❌ Application failed to start or crashed"
        currentBuild.result = 'FAILURE'
    }
    
    // Clean up log file
    sh "rm -f app.log || true"
}
