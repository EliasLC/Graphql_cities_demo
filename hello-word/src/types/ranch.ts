import { City } from "./City"

export class Ranch {
    id: String
    private name: String
    private description : String
    city: City | undefined

    constructor(id: String, name: String, description: String) {
        this.id = id
        this.name = name
        this.description = description
    }
}