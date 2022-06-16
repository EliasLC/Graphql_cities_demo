import axios from "axios";
import { apiUrl } from "./api.js";
import { getRanchCity } from "./extras.js";
export async function saveCity(cityData) {
    let newCity;
    newCity = await axios.post(apiUrl + "/cities", cityData)
        .then((response) => response.data)
        .catch((error) => console.log(error));
    console.log(newCity);
    return newCity;
}
export async function saveMunicipality(municipalityData) {
    let newMunicipality;
    console.log(municipalityData);
    const auxMunicipality = {
        name: municipalityData.name,
        description: municipalityData.description
    };
    newMunicipality = await axios.post(`${apiUrl}/cities/${municipalityData.cityId}/municipalities`, auxMunicipality).then((response) => response.data)
        .catch((error) => console.log(error));
    return newMunicipality;
}
export async function saveRanch(createRanchInput) {
    let newRanch;
    console.log(createRanchInput);
    const cityId = createRanchInput.cityId;
    const auxRanch = {
        name: createRanchInput.name,
        description: createRanchInput.description
    };
    newRanch = await axios.post(`${apiUrl}/cities/${cityId}/ranches`, auxRanch)
        .then((response) => response.data)
        .catch((error) => console.log(error));
    const ranchCity = await getRanchCity(newRanch);
    newRanch.city = ranchCity;
    return newRanch;
}
