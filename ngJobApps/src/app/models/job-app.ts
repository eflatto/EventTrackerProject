export class JobApp {
  id: number;
  companyName: string;
  jobDescription:string;
  notes:string;
  salary:number;
  jobTitle:string;
  dateApplied : Date;

  constructor(
    id:number = 0,
    companyName:string = '',
    jobDescription='',
    notes='',
    salary =0,
    jobTitle='',
    dateApplied= new Date()
  ){
    this.id = id;
    this.notes = notes;
    this.salary = salary;
    this.jobTitle = jobTitle;
    this.dateApplied= dateApplied;
    this.companyName= companyName;
    this.jobDescription = jobDescription;
  }
}
