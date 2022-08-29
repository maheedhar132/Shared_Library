def call(DB_PSWD,DB_URL,DB_USR){
   sh "export ${DB_PSWD}"
   sh "export ${DB_URL}"
   sh "export ${DB_USR}"
}