export class CreateRanchInput {

    cityId : string
    name : string
    description: string

    constructor(cityId: string, name: string, description: string) {
        this.cityId = cityId
        this.name = name
        this.description = description
    }
}