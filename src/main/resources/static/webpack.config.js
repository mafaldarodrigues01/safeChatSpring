const path = require('path')
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
    mode: 'development',
    entry : './index.js',
    output :  {
        filename : "main.js",
        path: path.resolve(__dirname, 'dist')
    },
    devServer: {
        hot: false,
        port: 8081,  // frontend port
        static: path.resolve(__dirname, 'dist'),
        historyApiFallback: true,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',  // backend port
                pathRewrite: {'^/api' : ''}
            }
        }
    },
    resolve: {
        extensions: ['.tsx', '.ts', '.js'],
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
        ],
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: './index.html',
        })
    ]
};