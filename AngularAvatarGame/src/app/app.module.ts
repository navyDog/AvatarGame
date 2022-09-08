import { NgModule } from '@angular/core';
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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationComponent,
    InventoryComponent,
    CraftComponent,
    MarketComponent,
    GalleryComponent,
    GamesComponent,
    NavigationTopComponent,
  ],
  imports: [BrowserModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
