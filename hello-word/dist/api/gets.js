import axios from "axios";
export async function getCities() {
    let result = '';
    await axios.get('http://localhost:8080/cities')
        .then((res) => {
        result = res.data;
    })
        .catch(error => console.log(error));
    return result;
}
