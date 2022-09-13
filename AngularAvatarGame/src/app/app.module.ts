import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component";
import { NavigationComponent } from "./config/navigation/navigation.component";
import { RouterModule } from "@angular/router";
import { routes } from "./routes";
import { InventoryComponent } from "./pages/inventory/inventory.component";
import { CraftComponent } from "./pages/craft/craft.component";
import { MarketComponent } from "./pages/market/market.component";
import { GalleryComponent } from "./pages/gallery/gallery.component";
import { GamesComponent } from "./pages/games/games.component";
import { NavigationTopComponent } from "./config/navigation-top/navigation-top.component";
import { SettingsComponent } from "./pages/settings/settings.component";
import { AuthComponent } from "./pages/auth/auth.component";
import { RegisComponent } from "./pages/regis/regis.component";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    InventoryComponent,
    CraftComponent,
    MarketComponent,
    GalleryComponent,
    GamesComponent,
    NavigationTopComponent,
    SettingsComponent,
    AuthComponent,
    RegisComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
