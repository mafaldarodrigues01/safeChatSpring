function storeUserInfo(user){
    console.log(user)
    sessionStorage.setItem('user',user)
}

function getStoreUserInfo(){
    const userInfo = sessionStorage.getItem('user')
    console.log(userInfo)
    if(userInfo != null) return userInfo
    return null
}

async function redirectPage(){

}