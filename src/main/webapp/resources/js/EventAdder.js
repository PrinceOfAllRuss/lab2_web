class EventAdder {
    graph;
    sender;

    constructor(graph) {
        this.graph = graph;
        this.sender = new Sender();
    }

    addEventForRadio() {
        let radios = document.getElementsByClassName("radio");
        for (let i = 0; i < radios.length; i++) {
            radios[i].addEventListener("change", () => this.graph.drawGraph());
        }
    }

    addEventForSubmit() {
        document.getElementById("submitBtn").addEventListener("click", () => {
            let nameOfBt = "submitBtn";
            this.sender.submitForm(nameOfBt);
        });
    }

    addEventForForm() {
        document.getElementById("myForm").addEventListener("submit", (event) => {
            event.preventDefault();
            this.sender.submitForm();
        });
    }
    
    addEventForMouseClickOnGraph() {
        this.graph.renderer.graph.addEventListener("mousedown", (event) => {
            this.graph.getMouseClick(event);
            
            let bt1 = document.getElementById("submitDotOnGraph");
            if (bt1.value === "false") {
                bt1.value = "true";
                bt1.classList.remove("hidden");
                let bt2 = document.getElementById("removeDotOnGraph");
                bt2.classList.remove("hidden");
            }
        });
    }
    
    addEventForSubmitDotOnGraph() {
        document.getElementById("submitDotOnGraph").addEventListener("click", () => {
            let bt1 = document.getElementById("submitDotOnGraph");
            if (bt1.value === "true") {
                let nameOfBt = "submitDotOnGraph";
                this.sender.submitForm(nameOfBt);
            }
        });
    }
    addEventForRemoveDotOnGraph() {
        document.getElementById("removeDotOnGraph").addEventListener("click", () => {
            let bt1 = document.getElementById("submitDotOnGraph");
            let bt2 = document.getElementById("removeDotOnGraph");
            bt1.value = "false";
            bt1.classList.add("hidden");
            bt2.classList.add("hidden");
            this.graph.removeDotFromGraph();
        });
    }
}