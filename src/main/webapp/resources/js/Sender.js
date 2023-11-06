class Sender {
    clientData;

    constructor() {
        this.clientData = new ClientData();
    }

    submitForm(nameOfBt) {
        let condition = this.clientData.getData(nameOfBt);
        console.log(this.clientData.x, this.clientData.y, this.clientData.r);
        let url = "http://localhost:8080/controller";
        let y = JSON.stringify(this.clientData.y);
        if (condition) {
            let self = this;
            $.ajax( {
                url: url,
                method: "get",
                dataType: "html",
                data: {"x": this.clientData.x, "y": y, "r": this.clientData.r, "event": this.clientData.event},
                success: function() {
                    location = "table.jsp";
                    console.log("done");
                }
            });
        }
    }
}