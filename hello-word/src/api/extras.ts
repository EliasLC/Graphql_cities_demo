import axios from "axios"
import { City } from "../types/City.js"
import { Ranch } from "../types/ranch.js"
import { apiUrl } from "./api.js"

export async function getRanchCity(ranch: Ranch) : Promise<City> {

    let city: City

    city = await axios.get(`${apiUrl}/ranches/${ranch.id}/cities`)
        .then((response) => response.data)
        .catch((error) => console.log(error))
        
        
    return city

}