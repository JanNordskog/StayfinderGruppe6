const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
    app.use(
        '/user', // Your backend API path
        createProxyMiddleware({
            target: 'http://localhost:8080', 
            changeOrigin: true,
        })
    );
};