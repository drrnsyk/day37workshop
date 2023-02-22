import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UploadService } from '../upload.service';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit{


  @ViewChild('file') 
  uploadedPicture!: ElementRef // this is the new file element that reference the html file input, it is the full file object, "picture" is only a path hence we use uploaded picture instead

  uploadForm!: FormGroup

  uploadStatus: string = "Pending upload"

  constructor(private fb: FormBuilder, private uploadSvc: UploadService) {}

  ngOnInit(): void {
    this.uploadForm = this.createForm()
  }

  upload() {
    console.info(this.uploadForm.value)
    console.info(this.uploadedPicture)
    const formData = new FormData() // use form data here because its multipart form data value type
    formData.set('comments', this.uploadForm.get('comments')?.value)
    formData.set('picture', this.uploadedPicture.nativeElement.files[0]) // retrieves the actual picture rather than the path
    this.uploadSvc.postCommentsWithPicture(formData)
      .then((result) => {
        console.info(">>> result: ", result)
        this.uploadStatus = "Upload successful"
      })
      .catch((error) => {
        console.info(">>> error")
        console.error(">>> error: ", error)
        this.uploadStatus = "Upload unsuccessful"
      })
        
  }

  // helper functions
  private createForm() {
    return this.fb.group({
      comments: this.fb.control('', Validators.required),
      picture: this.fb.control('', Validators.required)
    })
  }

}
