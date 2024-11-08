import $ from "jquery";
import {StudentCard} from "./StudentCard.js";
import {API_BASE_URL} from "../api/general.js";

export class StudentList {
    constructor() {
        this.$container = $('<div>')
            .addClass('student-list');
    }

    async loadData() {
        try {
            const students = await $.get(`${API_BASE_URL}/students`);

            this.$container.empty();

            console.log(students)

            students.forEach(student => {
                const $studentCard = new StudentCard(
                    student.id,
                    student.firstName,
                    student.lastName,
                    student.patronymic,
                    student.birthday,
                    student.group,
                    () => this.loadData()
                ).render()

                this.$container
                    .append($studentCard)
            })
        } catch (err) {
            console.error("Student upload error:" + err)
        }
    }

    render() {
        return this.$container
    }
}