export interface User {
    id?: number; // Optional if you are creating a new user
    name: string;
    phoneNumber: string;
    email: string;
    address: string;
    city: string;
    state: string;
    zipcode: string;
}