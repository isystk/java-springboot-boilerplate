console.log('process.env.NODE_ENV: ', process.env.NODE_ENV)

const Env = {
  apiEndpointUrl: process.env.REACT_APP_API_ENDPOINT_URL,
}

console.log('Env:', Env)

export default Env
