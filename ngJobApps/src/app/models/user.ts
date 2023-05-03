export class User {
  id: number;
  username: string;
  password: string;
  jobApplications: any[] | null;
  role: string;


  constructor(
    id: number = 0,
    username: string = '',
    password: string = '',
    role: string = '',
    jobApplications: any[] = []
  ) {
    this.id = id;
    this.username = username;
    this.role = role;
    this.password = password;
    this.jobApplications = jobApplications;
  }
}
