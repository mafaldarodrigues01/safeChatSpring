/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./handlers/homeHandler.js":
/*!*********************************!*\
  !*** ./handlers/homeHandler.js ***!
  \*********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__),\n/* harmony export */   homeHandlers: () => (/* binding */ homeHandlers)\n/* harmony export */ });\nfunction storeUserInfo(user){\r\n    console.log(user)\r\n    sessionStorage.setItem('user',user)\r\n}\r\n\r\nfunction getStoreUserInfo(){\r\n    const userInfo = sessionStorage.getItem('user')\r\n    console.log(userInfo)\r\n    if(userInfo != null) return userInfo\r\n    return null\r\n}\r\n\r\nasync function login(mainContent, query){\r\n    console.log(\"query=\",query)\r\n}\r\n\r\nasync function chat(mainContent, query){\r\n    console.log(\"query=\",query)\r\n}\r\n\r\nconst homeHandlers = {\r\n    login,\r\n    chat\r\n}\r\n\r\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (homeHandlers);\r\n\n\n//# sourceURL=webpack:///./handlers/homeHandler.js?");

/***/ }),

/***/ "./index.js":
/*!******************!*\
  !*** ./index.js ***!
  \******************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _router_js__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./router.js */ \"./router.js\");\n/* harmony import */ var _handlers_homeHandler_js__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./handlers/homeHandler.js */ \"./handlers/homeHandler.js\");\n\r\n\r\n\r\nwindow.addEventListener('load', loadHandler)\r\nwindow.addEventListener('hashchange', hashChangeHandler)\r\n\r\nfunction loadHandler(){\r\n    _router_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"].addRouteHandler(\"\", _handlers_homeHandler_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"].login)\r\n    _router_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"].addRouteHandler(\"chat.html/:id\", _handlers_homeHandler_js__WEBPACK_IMPORTED_MODULE_1__[\"default\"].chat)\r\n    _router_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"].addDefaultNotFoundRouteHandler(() => window.location.hash = \"\")\r\n    hashChangeHandler()\r\n}\r\n\r\nfunction hashChangeHandler() {\r\n    const mainContent = document.getElementById(\"mainContent\");\r\n    const path = window.location.hash.slice(1);\r\n    const handler  = _router_js__WEBPACK_IMPORTED_MODULE_0__[\"default\"].getRouteHandler(path)\r\n    handler.handler(mainContent, handler.param, handler.query);\r\n}\n\n//# sourceURL=webpack:///./index.js?");

/***/ }),

/***/ "./router.js":
/*!*******************!*\
  !*** ./router.js ***!
  \*******************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (__WEBPACK_DEFAULT_EXPORT__)\n/* harmony export */ });\nconst routes = []\r\nlet notFoundRouteHandler = () => { throw \"Route handler for unknown routes not defined\" }\r\n\r\nfunction addRouteHandler(path, handler){\r\n    routes.push({path, handler})\r\n}\r\nfunction addDefaultNotFoundRouteHandler(notFoundRH) {\r\n    notFoundRouteHandler = notFoundRH\r\n}\r\n\r\nfunction getRouteHandler(path) {\r\n    const route = routes.find(it => {\r\n        const routePath = it.path.split(\"/\")\r\n        const pathArr = path.split(\"/\")\r\n        if (routePath.length !== pathArr.length) {\r\n            return false\r\n        }\r\n        return routePath.every((part, index) => {\r\n            if(pathArr[index].includes(\"?\")){\r\n                pathArr[index] = pathArr[index].split(\"?\")[0]\r\n            }\r\n            return part === pathArr[index] || part.startsWith(\":\")\r\n        })\r\n    })\r\n    if (route === undefined) {\r\n        return {\r\n            \"handler\": notFoundRouteHandler,\r\n            \"param\": {},\r\n            \"query\": {}\r\n        }\r\n    }\r\n    const params = {}\r\n    const queries = {}\r\n    route.path.split(\"/\").forEach((part, index) => {\r\n        if (part.startsWith(\":\")) {\r\n            params[part.slice(1)] = path.split(\"/\")[index]\r\n        }\r\n    })\r\n\r\n    if(path.includes(\"?\")){\r\n        const query = path.split(\"?\")[1]\r\n        query.split(\"&\").forEach(part => {\r\n            const [key, value] = part.split(\"=\")\r\n            queries[key] = value\r\n        })\r\n    }\r\n    return {\r\n        \"handler\": route.handler,\r\n        \"param\": params,\r\n        \"query\": queries\r\n    }\r\n}\r\n\r\nconst router = {\r\n    addRouteHandler,\r\n    getRouteHandler,\r\n    addDefaultNotFoundRouteHandler\r\n}\r\n/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (router);\n\n//# sourceURL=webpack:///./router.js?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/define property getters */
/******/ 	(() => {
/******/ 		// define getter functions for harmony exports
/******/ 		__webpack_require__.d = (exports, definition) => {
/******/ 			for(var key in definition) {
/******/ 				if(__webpack_require__.o(definition, key) && !__webpack_require__.o(exports, key)) {
/******/ 					Object.defineProperty(exports, key, { enumerable: true, get: definition[key] });
/******/ 				}
/******/ 			}
/******/ 		};
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/hasOwnProperty shorthand */
/******/ 	(() => {
/******/ 		__webpack_require__.o = (obj, prop) => (Object.prototype.hasOwnProperty.call(obj, prop))
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./index.js");
/******/ 	
/******/ })()
;