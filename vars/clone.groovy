def call(String url, String branch) {
  echo "This is cloning the code"
  git url: "${url}", branch: "${Branch}"
  echo "Code cloning successful"
}
