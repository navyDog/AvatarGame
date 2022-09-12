package formation.sopra.AvatarGameBoot.entities.view;



public class JsonViews {
	public static class Base {}
	
	public static class Avatar extends Base{}

	public static class AvatarWithItem extends Avatar {}
	
	public static class Item extends Base{}
	
	public static class ItemUpdate extends Item {}
	
	public static class Users extends Base{}
	
	public static class UsersInfo extends Users{}
	
	public static class UsersWithItems extends Users{}
	
	public static class UsersWithAvatars extends Users{}
	
	public static class Utilisateur extends Base{}
}	
