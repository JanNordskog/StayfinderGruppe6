const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
    const API_BASE_PATH = process.env.REACT_APP_API_BASE_PATH;

    app.use(
        '/user', // Your backend API path
        createProxyMiddleware({
            target: API_BASE_PATH,
            changeOrigin: true,
        })
    );
};
