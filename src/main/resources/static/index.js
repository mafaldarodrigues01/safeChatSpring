import router from "./router.js";
import cardHandlers from "./handlers/homeHandlers.js";


function loadHandler(){
    router.addRouteHandler("", boardHandlers.getHome)
    router.addDefaultNotFoundRouteHandler(() => window.location.hash = "")
    hashChangeHandler()
}

function hashChangeHandler() {
    const mainContent = document.getElementById("mainContent");
    const path = window.location.hash.slice(1);
    const handler  = router.getRouteHandler(path)
    handler.handler(mainContent, handler.param, handler.query);
}