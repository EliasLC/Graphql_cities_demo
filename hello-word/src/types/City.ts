import { Municipality } from "./Municipality.js"
import { Ranch } from "./ranch"

export class City {
    private id: String
    private name: String
    private municipalies: [Municipality]
    private raches: [Ranch]


    constructor(id: String, name: String, municipalies: [Municipality], ranches: [Ranch]) {
        this.id = id
        this.name = name
        this.municipalies = municipalies
        this.raches = ranches
    }

}