/*
*   Plots android accelerometer data locally and remotely 
*
*/

var plot, plot2; 
var webPlot; 

//start button, when press add plots and start accelerometer 
ui.button("Start Accelerometer", 0, 0, ui.screenWidth, 200, function() {
        //change title to on 
        ui.title("on!");

        dashboard.show(true);

        //add android plots 
        plot = ui.addPlot(0, 500, ui.screenWidth, 250, -12, 12); 
        plot2 = ui.addPlot(0, 800, ui.screenWidth, 250, -12, 12); 

        //add webplot 
        webPlot = dashboard.addPlot("x_axys", 400, 100, 250, 100);

        sensors.startAccelerometer(function(x,y,z) {
            //update plots
            webPlot.update(x);
            plot.update(x);
            plot2.update(y);
          }
       );
});

//stop accelerometer 
ui.button("Stop Accelerometer", 0, 300, ui.screenWidth, 200, function() { 
    dashboard.show(false);
    sensors.stopAccelerometer();
});