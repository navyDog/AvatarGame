import { Component } from "@angular/core";
import { AuthGuardService } from "./config/services/auth-guard.service";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "AvatarGame";
  navDisplay = AuthGuardService;

  public logged(): boolean {
    if (sessionStorage.getItem("token")) {
      return true;
    } else {
      return false;
    }
  }
}
