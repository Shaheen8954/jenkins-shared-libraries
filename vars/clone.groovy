def call(String url, String branch) {
  echo "This is cloning the code"
  git url: "${Url}", branch: "${Branch}"
  echo "Code cloning successful"
}
