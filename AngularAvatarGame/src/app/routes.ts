import { Routes } from "@angular/router";
import { InventoryComponent } from "./pages/inventory/inventory.component";
import { CraftComponent } from "./pages/craft/craft.component";
import { MarketComponent } from "./pages/market/market.component";
import { GalleryComponent } from "./pages/gallery/gallery.component";
import { GamesComponent } from "./pages/games/games.component";
import { AuthComponent } from "./pages/auth/auth.component";
import { RegisComponent } from "./pages/regis/regis.component";
import { SettingsComponent } from "./pages/settings/settings.component";
import { AuthGuardService } from "./config/services/auth-guard.service";

export const routes: Routes = [
  {
    path: "inventory",
    component: InventoryComponent,
    canActivate: [AuthGuardService],
  },
  { path: "craft", component: CraftComponent, canActivate: [AuthGuardService] },
  {
    path: "market",
    component: MarketComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: "gallery",
    component: GalleryComponent,
    canActivate: [AuthGuardService],
  },
  { path: "games", component: GamesComponent, canActivate: [AuthGuardService] },
  {
    path: "settings",
    component: SettingsComponent,
    canActivate: [AuthGuardService],
  },

  { path: "auth", component: AuthComponent },
  { path: "regis", component: RegisComponent },
  { path: "**", redirectTo: "/inventory", pathMatch: "full" },
];
