class Employee {
    setName(name) {this.name=name}
    getName() {return this.name}
    setID(idNumber) {this.idNumber=idNumber}
    getID() {return this.idNumber}
    setDoB(dateOfBirth) {this.dateOfBirth=dateOfBirth}
    getDoB() {return this.dateOfBirth}
    setEmail(email) {this.email=email}
    getEmail() {return this.email}
    setAdress(address) {this.address=address}
    getAdress() {return this.address}
    setPhone(phone) {this.phone=phone}
    getPhone() {return this.phone}
    setLevel(level) {this.level=level}
    getLevel() {return this.level}
    setLocation(location) {this.location=location}
    getLocation() {return this.location}
    getSalary() {
        switch (this.getLocation()) {
            case "Manager": this.salary=500; break;
            case "Sale": this.salary=300; break;
            case "Marketing": this.salary=200; break;
        }
        return this.salary;
    }

}