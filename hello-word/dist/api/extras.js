import axios from "axios";
import { apiUrl } from "./api.js";
export async function getRanchCity(ranch) {
    let city;
    city = await axios.get(`${apiUrl}/ranches/${ranch.id}/cities`)
        .then((response) => response.data)
        .catch((error) => console.log(error));
    return city;
}
