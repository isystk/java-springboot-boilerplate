const path = require('path');

module.exports = (config) => {
  config.resolve = {
    ...config.resolve,
    extensions: ['.ts', '.tsx', '.js', '.json'],
    alias: {
      ...config.alias,
      '@': path.resolve(__dirname, './src/'),
    },
  };

  return config;
};