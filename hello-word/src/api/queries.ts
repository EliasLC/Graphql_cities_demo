import axios from "axios";
import { City } from "../types/City";
import { Municipality } from "../types/Municipality";
import { apiUrl } from "./api.js";

export async function getCities(name: string) : Promise<[City]> { 
    let result : [City]

    const requestParam = name !== undefined ? `?name=${name}` : ''

    result = await axios.get(`${apiUrl}/cities${requestParam}`)
    .then((res) => res.data)
    .catch(error => console.log(error))

    return result
}


export async function getMunicipalities(name: string) : Promise<[Municipality]>{
    let result : [Municipality]

    const requestParam = name !== undefined ? `?name=${name}` : ''

    result = await axios.get(`${apiUrl}/municipalities${requestParam}`)
        .then((response) => response.data)
        .catch((error) => console.log(error))

    await getMunicipalitieCity(result)

    console.log(result)

    return result
}

async function getMunicipalitieCity(municipalities: [Municipality]) {
        for(let i =0; i<municipalities.length; i++) {

            const municipality = municipalities[i]
            const municipalityId = municipality.id

            municipality.city = await axios.get(`${apiUrl}/municipalities/${municipalityId}/city`)
            .then((res) => res.data)
            .catch((error) => console.log(error))
    
            console.log(municipality.city)

        }
}