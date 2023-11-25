const routes = []
let notFoundRouteHandler = () => { throw "Route handler for unknown routes not defined" }

function addRouteHandler(path, handler){
    routes.push({path, handler})
}
function addDefaultNotFoundRouteHandler(notFoundRH) {
    notFoundRouteHandler = notFoundRH
}

function getRouteHandler(path) {
    const route = routes.find(it => {
        const routePath = it.path.split("/")
        const pathArr = path.split("/")
        if (routePath.length !== pathArr.length) {
            return false
        }
        return routePath.every((part, index) => {
            if(pathArr[index].includes("?")){
                pathArr[index] = pathArr[index].split("?")[0]
            }
            return part === pathArr[index] || part.startsWith(":")
        })
    })
    if (route === undefined) {
        return {
            "handler": notFoundRouteHandler,
            "param": {},
            "query": {}
        }
    }
    const params = {}
    const queries = {}
    route.path.split("/").forEach((part, index) => {
        if (part.startsWith(":")) {
            params[part.slice(1)] = path.split("/")[index]
        }
    })

    if(path.includes("?")){
        const query = path.split("?")[1]
        query.split("&").forEach(part => {
            const [key, value] = part.split("=")
            queries[key] = value
        })
    }
    return {
        "handler": route.handler,
        "param": params,
        "query": queries
    }
}

const router = {
    addRouteHandler,
    getRouteHandler,
    addDefaultNotFoundRouteHandler
}
export default router