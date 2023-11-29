import router from "./router.js";
import homeHandlers from "./handlers/homeHandler.js";

window.addEventListener('load', loadHandler)
window.addEventListener('hashchange', hashChangeHandler)

function loadHandler(){
    router.addRouteHandler("", homeHandlers.login)
    router.addRouteHandler("chat.html/:id", homeHandlers.chat)
    router.addDefaultNotFoundRouteHandler(() => window.location.hash = "")
    hashChangeHandler()
}

function hashChangeHandler() {
    const mainContent = document.getElementById("mainContent");
    const path = window.location.hash.slice(1);
    const handler  = router.getRouteHandler(path)
    handler.handler(mainContent, handler.param, handler.query);
}