import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    @get: OnGet
    val isGrowing = true

    @set: OnSet
    var needsFood = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
    val classObj = Plant::class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name)
    }

    // Print all annotations
    for (annotations in classObj.annotations) {
        println(annotations.annotationClass.simpleName)
    }

    // Find one annotation, or null
    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated?.apply {
        println("Found a plant annotation!")
    }
}