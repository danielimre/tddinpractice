// Karma configuration
// Generated on Tue Sep 10 2013 18:55:35 GMT+0200 (Közép-európai nyári idő )
var devConfig = require('./conf-dev.js');

module.exports = function(config) {
    devConfig(config);
    config.set({
        preprocessors: {
            'main/js/**/*.js' : ['coverage']
        },
        coverageReporter: {
          type : 'html',
          dir : '../target/karma-coverage'
        },
        reporters: ['dots', 'coverage'],
        colors: false,
        autoWatch: false,
        singleRun: true
    });
};
