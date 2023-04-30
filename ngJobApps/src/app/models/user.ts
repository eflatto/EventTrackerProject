export class User {
  id: number;
  username: string;
  password: string;
  jobApplications: any[] | null;


  constructor(
    id: number = 0,
    username: string = '',
    password: string = '',
    jobApplications: any[] = []
  ) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.jobApplications = jobApplications;
  }
}
