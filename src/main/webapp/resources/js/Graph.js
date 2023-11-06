class Graph {
    clientData;
    renderer;
    
    constructor(clientData) {
        this.clientData = clientData;
        this.renderer = new Renderer();
    }
    
    drawGraph() {
        let radiuses = document.querySelectorAll(".radio");
        for (let i = 0; i < radiuses.length; i++) {
            if (radiuses[i].checked) {
                this.clientData.r = Number(radiuses[i].value);
                break;
            }
        }
        this.renderer.drawGraph(this.clientData.r);
    }
    
    getMouseClick(event) {
        let rect = this.renderer.graph.getBoundingClientRect();
        let x = event.clientX - rect.left;
        let y = rect.top - event.clientY;
        
        let coordX = (x - this.renderer.xAxis) / this.renderer.scaleX;
        let coordY = (y + this.renderer.yAxis) / this.renderer.scaleY;
        
        let dot = new Dot(coordX, coordY, "default");
        window.sessionStorage.setItem("clickDot", JSON.stringify(dot));
        
        this.drawGraph();
    }
    
    removeDotFromGraph() {
        window.sessionStorage.setItem("clickDot", null);
        this.drawGraph();
    }
}