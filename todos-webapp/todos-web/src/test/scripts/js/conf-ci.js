// Karma configuration
// Generated on Tue Sep 10 2013 18:55:35 GMT+0200 (Közép-európai nyári idő )

module.exports = function(config) {
  config.set({

    // base path, that will be used to resolve files and exclude
    basePath: '../../..',


    // frameworks to use
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [
      'test/js/lib/angular/angular.js',
      'test/js/lib/angular/angular-mocks.js',
      'main/js/**/*.js',
      'test/js/**/*Spec.js'
    ],

    // list of files to exclude
    exclude: [
      'main/js/**/app.js'
    ],

    preprocessors: {
        'main/js/**/*.js' : ['coverage']
    },

    coverageReporter: {
      type : 'html',
      dir : '../target/karma-coverage'
    },

    // test results reporter to use
    // possible values: 'dots', 'progress', 'junit', 'growl', 'coverage'
    reporters: ['dots', 'coverage'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: false,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: false,


    // Start these browsers, currently available:
    // - Chrome
    // - ChromeCanary
    // - Firefox
    // - Opera
    // - Safari (only Mac)
    // - PhantomJS
    // - IE (only Windows)
    browsers: ['Chrome'],


    // If browser does not capture in given timeout [ms], kill it
    captureTimeout: 60000,


    // Continuous Integration mode
    // if true, it capture browsers, run tests and exit
    singleRun: true
  });
};
