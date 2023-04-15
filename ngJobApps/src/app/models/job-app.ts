export class JobApp {
  id: number;
  companyName: string;
  jobDescription:string;

  constructor(
    id:number = 0,
    companyName:string = '',
    jobDescription=''
  ){
    this.id = id;
    this.companyName= companyName;
    this.jobDescription = jobDescription;
  }
}
