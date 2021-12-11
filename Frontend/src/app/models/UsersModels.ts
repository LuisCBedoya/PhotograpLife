import { ImagesModels } from "./ImagesModels";
export interface usersModels{
    name:        string;
    lastName:    string;
    email:       string;
    userName:    string;
    password:    string;
    description: string;
    hash:        string;
    userImage:   string;
    imgGallery:  ImagesModels;
}