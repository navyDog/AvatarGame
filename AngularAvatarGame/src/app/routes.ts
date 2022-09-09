import { Routes } from '@angular/router';
import { InventoryComponent } from './pages/inventory/inventory.component';
import { CraftComponent } from './pages/craft/craft.component';
import { MarketComponent } from './pages/market/market.component';
import { GalleryComponent } from './pages/gallery/gallery.component';
import { GamesComponent } from './pages/games/games.component';
import { AuthComponent } from './pages/auth/auth.component';
import { RegisComponent } from './pages/regis/regis.component';
import { SettingsComponent } from './pages/settings/settings.component';

export const routes: Routes = [
  { path: 'inventory', component: InventoryComponent },
  { path: 'craft', component: CraftComponent },
  { path: 'market', component: MarketComponent },
  { path: 'gallery', component: GalleryComponent },
  { path: 'games', component: GamesComponent },
  { path: 'settings', component: SettingsComponent },

  { path: 'auth', component: AuthComponent },
  { path: 'regis', component: RegisComponent },
  { path: '**', redirectTo: '/inventory', pathMatch: 'full' },
];
