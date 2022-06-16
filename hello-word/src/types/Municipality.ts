import { City } from "./City";

export class Municipality {

    id: string
    private name: string
    private description: string
    city!: City;

    constructor(id: string, name: string, description: string) {
        this.id = id;
        this.name = name
        this.description = description
    }

}