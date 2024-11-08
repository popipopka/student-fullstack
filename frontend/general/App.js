import {StudentList} from "../components/StudentList.js";
import $ from "jquery";
import {StudentForm} from "../components/StudentForm.js";

export class App {
    init() {
        const studentList = new StudentList();
        const studentForm = new StudentForm()

        this.append(studentForm.render());

        studentList.loadData().then(() =>
            this.append(studentList.render())
        )
    }

    append(el) {
        $('#app').append(el)
    }
}