import { saveCity, saveMunicipality, saveRanch } from "../api/mutations.js";
import { getCities, getMunicipalities } from "../api/queries.js";
export const resolvers = {
    Query: {
        cities: async (_root, { name }) => {
            const result = await getCities(name);
            return result;
        },
        municipalities: async (_root, { name }) => {
            const result = await getMunicipalities(name);
            return result;
        }
    },
    Mutation: {
        createCity: async (_root, { data }) => {
            console.log(data);
            const result = await saveCity(data);
            return result;
        },
        createMunicipality: async (_root, { data }) => {
            console.log(data);
            const result = await saveMunicipality(data);
            return result;
        },
        createRanch: async (_root, { data }) => {
            console.log(data);
            const result = await saveRanch(data);
            return result;
        }
    }
};
