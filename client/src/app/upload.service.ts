import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom } from "rxjs";

@Injectable()
export class UploadService {

    constructor(private http: HttpClient) {}

    postCommentsWithPicture(formData: FormData) {
        
        const headers = new HttpHeaders()
        .set('Content-Type', 'multipart/form-data')
        .set('Accept', 'application/json')

        return firstValueFrom(
            this.http.post(`/api/post`, formData)
        )
    }

}