import { ApolloServer, gql } from 'apollo-server'
import { readFile } from 'fs/promises'
import { resolvers } from './resolvers/main.js'

const typeDefs = await readFile('./graphql/schema.graphql', 'utf8')

const server = new ApolloServer({typeDefs, resolvers})

const serverInfo = await server.listen({port: 9000})

console.log(serverInfo.url) 