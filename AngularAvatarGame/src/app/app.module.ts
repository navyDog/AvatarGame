import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NavigationComponent } from './config/navigation/navigation.component';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { InventoryComponent } from './pages/inventory/inventory.component';
import { CraftComponent } from './pages/craft/craft.component';
import { MarketComponent } from './pages/market/market.component';
import { GalleryComponent } from './pages/gallery/gallery.component';
import { GamesComponent } from './pages/games/games.component';
import { NavigationTopComponent } from './config/navigation-top/navigation-top.component';
import { SettingsComponent } from './pages/settings/settings.component';
import { AuthComponent } from './pages/auth/auth.component';
import { RegisComponent } from './pages/regis/regis.component';

@NgModule({
  declarations: [
<<<<<<< HEAD
    AppComponent
  ],
  imports: [
    BrowserModule, FormsModule
=======
    AppComponent,
    HomeComponent,
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
>>>>>>> e2b43961bb96e1f4928780112a49b95f335738c7
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
