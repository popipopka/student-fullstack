import {Button} from "./Button.js"
import $ from "jquery"
import {API_BASE_URL} from "../api/general.js";

export class StudentCard {
    constructor(id, firstName, lastName, patronymic, birthday, group, deleteCallback) {
        this.id = id;
        this.firstName = firstName
        this.lastName = lastName
        this.patronymic = patronymic
        this.birthday = new Date(birthday)
        this.group = group
        this.deleteCallback = deleteCallback
    }

    getFullName() {
        return `${this.firstName} ${this.lastName} ${this.patronymic}`
    }

    beautifyBirthday() {
        return this.birthday.toLocaleDateString('ru-RU', {year: 'numeric', month: '2-digit', day: '2-digit'})
    }

    render() {
        const $studentCard = $('<div>')
            .addClass('student-card')

        const $studentPhoto = $('<img>')
            .attr('src', '/assets/student_photo.svg')
            .attr('alt', 'Фото студента')
            .addClass('student-photo')

        const $studentInfo = $('<div>')
            .addClass('student-info')

        const $deleteButton = new Button("Удалить", () => $.ajax({
            url: `${API_BASE_URL}/students/${this.id}`,
            type: 'DELETE',
            success: () => {
                this.deleteCallback();
            }
        })).render()

        $studentInfo.append(
            $('<h2>')
                .addClass('student-name')
                .text(this.getFullName()),

            $('<p>')
                .addClass('student-birthday')
                .text(`Дата рождения: ${this.beautifyBirthday()}`),

            $('<p>')
                .addClass('student-group')
                .text(`Группа: ${this.group}`),

            $deleteButton
        );

        $studentCard
            .append($studentPhoto, $studentInfo);

        return $studentCard;
    }
}