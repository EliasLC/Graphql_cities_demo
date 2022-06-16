import axios from "axios";
import { CityInput } from "../inputs/city_input";
import { CreateRanchInput } from "../inputs/create_ranch_input";
import { MunicipalityInput } from "../inputs/MunicipalityInput";
import { City } from "../types/City";
import { Municipality } from "../types/Municipality.js";
import { Ranch } from "../types/ranch.js";
import { apiUrl } from "./api.js";
import { getRanchCity } from "./extras.js"

export async function saveCity (cityData: CityInput): Promise<City> {
    let newCity : City
    
    newCity = await axios.post(apiUrl+"/cities",cityData)
    .then((response) => response.data)
    .catch((error) => console.log(error))

    console.log(newCity)

    return newCity
}

export async function saveMunicipality(municipalityData: MunicipalityInput): Promise<Municipality> {
    let newMunicipality : Municipality

    console.log(municipalityData)

    const auxMunicipality = {
        name: municipalityData.name,
        description: municipalityData.description
     }

    newMunicipality = await axios.post(
        `${apiUrl}/cities/${municipalityData.cityId}/municipalities`, 
        auxMunicipality
    ).then((response) => response.data)
    .catch((error) => console.log(error))

    return newMunicipality
}

export async function saveRanch(createRanchInput: CreateRanchInput) : Promise<Ranch>{

    let newRanch : Ranch

    console.log(createRanchInput)

    const cityId = createRanchInput.cityId

    const auxRanch = {
        name: createRanchInput.name,
        description: createRanchInput.description
    }

    newRanch = await axios.post(`${apiUrl}/cities/${cityId}/ranches`, auxRanch)
        .then((response) => response.data)
        .catch((error) => console.log(error))

    const ranchCity = await getRanchCity(newRanch)

    newRanch.city = ranchCity

    return newRanch
}

