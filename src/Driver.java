import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;	
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * @author lytte
 *Welcome to an RPG inspired by the games of the early 80s
 *This program is built off pushing and pulling information from setters and getters
 *
 */
public class Driver extends Application {
	private static Player player = new Player();
	private static Skeleton skeleton = new Skeleton();
public static void main(String[] args) {
	launch(args);

}


private Text outpute;
private Text outputp;
private Text woutputp;
private Text woutpute;

private void turn(String message){
	
	
	System.out.println(message);
	outpute.setText(skeleton.toString());
	outputp.setText(player.toString());
	
}


@Override
public void start(Stage primaryStage) {
	
	Button DoNothing = new Button("you do nothing...");
	Button Attack = new Button("Attack");
	Button Defend = new Button("Defend");
	Label name = new Label("Name");
	TextField inputName = new TextField("Name here");
	outpute = new Text("Enemy events");
	outputp = new Text("Player events");
	woutputp = new Text("World events");
	woutpute = new Text("Skeleton actions");
	

	

Attack.setOnAction(new EventHandler<ActionEvent>() {
//the above starts after the player clicks attack
	@Override
	public void handle(ActionEvent attack) {
	
		
	
		
		//above
		woutputp.setText(inputName.getText() +" attacks!");
		
		int Tunap=player.getHp();
		int Tuna=skeleton.getHp();
		if(Tuna<=0){
			JOptionPane.showMessageDialog(null, "Congrats "+inputName.getText() +" you killed 'A cool guy'... You monster");
			System.exit(0);
		}
		if(Tunap<=0) {
			JOptionPane.showMessageDialog(null, "You were defeated by 'a cool guy', better then killing him at least");
		System.exit(1);
		}
		player.attack(skeleton);
		
		turn("Player attack");
		double result = Math.random()*100;
		if(result>25){
		skeleton.attack(player);
		woutpute.setText("Skeleton attacks!");
		}
		if(result<25){
		skeleton.defend(player);
		woutpute.setText("Skeleton defends");
		}
		if(Tuna<=0){
			JOptionPane.showMessageDialog(null, "Congrats "+inputName.getText() +" you killed 'A cool guy'... You monster");
			System.exit(0);
		}
		if(Tunap<=0) {
			JOptionPane.showMessageDialog(null, "You were defeated by 'a cool guy', better then killing him at least");
		System.exit(1);
		}
		
		}


});
DoNothing.setOnAction(new EventHandler<ActionEvent>(){
	//Starts when the player clicks on the DoNothing button
	@Override
	public void handle(ActionEvent DoNothing) {
		woutputp.setText("You do nothing...");
		double result = Math.random()*100;
		turn("Player does noting");
		int Tunap=player.getHp();
		int Tuna=skeleton.getHp();
		if(Tuna<=0){
			JOptionPane.showMessageDialog(null, "Congrats "+inputName.getText() +" you killed 'A cool guy'... You monster");
			System.exit(0);
		}
		if(Tunap<=0) {
			JOptionPane.showMessageDialog(null, "You were defeated by 'a cool guy', better then killing him at least");
		System.exit(1);
		}
		
		if(result>25 && result<98){
		skeleton.attack(player);
		woutpute.setText("Skeleton attacks!");
		}
		if(result>97) {
			woutputp.setText("He spares you, what a cool guy");
			JOptionPane.showMessageDialog(null, "He spares you, what a cool guy, True end");
			System.exit(2);
		}
	}
});

Defend.setOnAction(new EventHandler<ActionEvent>() {
//Starts when the user clicks "Defend"
	@Override
	public void handle(ActionEvent Defend) {
		woutputp.setText(inputName.getText()+" defends, Critical defense!");
	player.defend(skeleton);	
	turn("Player defends");
	int Tunap=player.getHp();
	int Tuna=skeleton.getHp();
	if(Tuna<=0){
		JOptionPane.showMessageDialog(null, "Congrats "+inputName.getText() +" you killed 'A cool guy'... You monster");
		System.exit(0);
	}
	if(Tunap<=0) {
		JOptionPane.showMessageDialog(null, "You were defeated by 'a cool guy', better then killing him at least");
	System.exit(1);
	}
	player.attack(skeleton);
	
	turn("Player attack");
	double result = Math.random()*100;
	if(result>25){
	skeleton.attack(player);
	woutpute.setText("Skeleton attacks!");
	}
	if(result<25){
	skeleton.defend(player);
	woutpute.setText("Skeleton defends");
	}

	}
});

GridPane grid = new GridPane();
//the above is the grid for the Javafx console
grid.setAlignment(Pos.TOP_CENTER);
grid.setVgap(50);
grid.setHgap(30);
grid.add(name, 0, 0);
grid.add(inputName, 1, 0);
grid.add(Attack, 0, 2);
grid.add(woutputp, 0, 5);
grid.add(outputp, 0, 6);
grid.add(woutpute, 0, 7);
grid.add(outpute, 0, 8);
grid.add(Defend, 1, 2);
grid.add(DoNothing, 2, 2);
Scene scene = new Scene(grid, 500, 500);
primaryStage.setScene(scene);
primaryStage.show();
}
}