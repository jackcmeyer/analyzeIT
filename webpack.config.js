var webpack = require('webpack');
var debug = true;

module.exports = {
    context: __dirname,
    devtool: debug? "inline-sourcemap" : null,
    entry: "./src/main/resources/static/scripts.js",
    module: {
        loaders: [
            {
                test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/,
                loader: 'babel-loader',
                query: {
                    presets: ['react', 'es2015'],
                    plugins: ['react-html-attrs', 'transform-class-properties'],
                }
            }
        ]
    },
    output: {
        path: "./src/main/resources/static",
        filename: "scripts.min.js"
    },
    plugins: debug ? [] : [
        new webpack.optimize.DedupePlugin(),
        new webpack.optimize.OccurenceOrderPlugin(),
        new webpack.optimize.UglifyJsPlugin({ mangle: false, sourcemap: false })
    ]
};