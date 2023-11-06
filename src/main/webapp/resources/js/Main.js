window.onload = function() {

    const clientData = new ClientData();
    const graph = new Graph(clientData);
    
    graph.removeDotFromGraph();
    graph.drawGraph();

    const eventAdder = new EventAdder(graph);
    eventAdder.addEventForRadio();
    eventAdder.addEventForSubmit();
    eventAdder.addEventForForm();
    eventAdder.addEventForMouseClickOnGraph();
    eventAdder.addEventForSubmitDotOnGraph();
    eventAdder.addEventForRemoveDotOnGraph();
};